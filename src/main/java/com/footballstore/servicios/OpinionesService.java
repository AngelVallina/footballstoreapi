package com.footballstore.servicios;

import java.util.List;

import com.footballstore.modelo.OpinionProductoUsuarioRequestDTO;
import com.footballstore.modelo.OpinionVO;
public interface OpinionesService {

	List<OpinionProductoUsuarioRequestDTO> findByProducto_Id(int producto);
	OpinionVO addOpinion(OpinionProductoUsuarioRequestDTO opinion);
	float getValoracionMedia(int idProducto);
}
