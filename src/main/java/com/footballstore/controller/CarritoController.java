package com.footballstore.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.footballstore.modelo.CheckoutPaymentVO;
import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;


/**
 * Clase encargada de la pasarela de pago con Stripe
 * @author avallina
 *
 */
@RestController
@RequestMapping("/carrito")
@CrossOrigin
public class CarritoController {
	private static Gson gson = new Gson();

	/**
	 * Crea una sesion de stripe
	 * @param payment CheckoutPaymentVO
	 * @return json -> { "id" : id de la sesion de stripe}
	 * @throws StripeException
	 */
	@RequestMapping(value = "/pay" , method = RequestMethod.POST)
	public String paymentWithCheckoutPage(@RequestBody CheckoutPaymentVO payment) throws StripeException {
		// We initilize stripe object with the api key
		init();
		// We create a  stripe session parameters
		SessionCreateParams params = SessionCreateParams.builder()
				// We will use the credit card payment method 
				.addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
				.setMode(SessionCreateParams.Mode.PAYMENT).setSuccessUrl(payment.getSuccessUrl())
				.setCancelUrl(
						payment.getCancelUrl())
				.addLineItem(
						SessionCreateParams.LineItem.builder().setQuantity(payment.getQuantity())
								.setPriceData(
										SessionCreateParams.LineItem.PriceData.builder()
												.setCurrency(payment.getCurrency()).setUnitAmount(payment.getAmount())
												.setProductData(SessionCreateParams.LineItem.PriceData.ProductData
														.builder().setName(payment.getName()).build())
												.build())
								.build())
				.build();

		// create a stripe session
		Session session = Session.create(params);
		Map<String, String> responseData = new HashMap<>();
		// We get the sessionId and we putted inside the response data you can get more info from the session object
		responseData.put("id", session.getId());
		// We can return only the sessionId as a String
		return gson.toJson(responseData);
	}

	private static void init() {
		Stripe.apiKey = "sk_test_51KjJsMKB0Jn2rWO2GeZYnaeaArne9LUG6nQJS4vZDqGhKEg3HY20shiSZwkTrRAhcn3Dvy3i4VL5VmD5UUjKj3vL002JONaC4q";
	}
}

