package com.danjimlon.inditex.commons;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Constants {
	
	 private Constants() {}
		/**
		 * Http messages
		 */
		public static final String MESSAGE_INTERNAL_ERROR = "Error interno, contacte con el administrador";

		public static final String MESSAGE_PRICE_NOT_FOUND = "Precio no encontrado";

		public static final String MESSAGE_PRICE_FOUND = "Precio encontrado";

	}
