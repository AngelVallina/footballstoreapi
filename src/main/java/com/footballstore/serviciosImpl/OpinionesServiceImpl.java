package com.footballstore.serviciosImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballstore.modelo.OpinionProductoUsuarioRequestDTO;
import com.footballstore.modelo.OpinionVO;
import com.footballstore.modelo.ProductoVO;
import com.footballstore.repositorio.OpinionesRepository;
import com.footballstore.repositorio.ProductoRepository;
import com.footballstore.servicios.OpinionesService;
import com.footballstore.servicios.ProductosService;
import com.footballstore.servicios.UserService;

@Service
public class OpinionesServiceImpl implements OpinionesService{

	@Autowired
	OpinionesRepository opinionRepository;
	
	@Autowired
	ProductoRepository productosRepository;
	
	@Autowired
	ProductosService productoService;
	
	@Autowired
	UserService usuariosService;

	@Override
	public List<OpinionProductoUsuarioRequestDTO> findByProducto_Id(int producto) {
		List<OpinionVO> listadoOpiniones = opinionRepository.findByProducto_Id(producto);
		List<OpinionProductoUsuarioRequestDTO> listadoResumido = new ArrayList<>();
		for (OpinionVO opinion : listadoOpiniones) {
			listadoResumido.add(new OpinionProductoUsuarioRequestDTO(opinion.getProducto().getId(),
					opinion.getUsuario().getId().intValue(),
					opinion.getComentario() ,
					opinion.getValoracion(),
					opinion.getUsuario().getNombre()));
		}
		return listadoResumido;
	}


	@Override
	public OpinionVO addOpinion(OpinionProductoUsuarioRequestDTO request) {
		OpinionVO opinionNueva = new OpinionVO();
		
		opinionNueva.setComentario(request.getComentario());		
		opinionNueva.setProducto(productosRepository.findById(request.getIdProducto()));
		opinionNueva.setUsuario(usuariosService.findById( (long) request.getIdUsuario()).orElseThrow(() -> new RuntimeException("Error: Usuario no encontrado")));
		opinionNueva.setValoracion(request.getValoracion());
		
		opinionRepository.save(opinionNueva);
		//Actualiza la valoracion media
		ProductoVO producto =  productosRepository.findById(request.getIdProducto());
		producto.setValoracion(getValoracionMedia(producto.getId()));
		productoService.save(producto);

		
		//TODO corregir fallo de serializacoin al intertar devolver la opinion guardada
		return new OpinionVO();
	}


	@Override
	public float getValoracionMedia(int idProducto) {
		List<OpinionVO> opiniones = opinionRepository.findByProducto_Id(idProducto);
		float sumatorio = 0;
		for (OpinionVO opinion : opiniones) {
			sumatorio+=opinion.getValoracion();
		}
		return sumatorio/opiniones.size();
	}

}
