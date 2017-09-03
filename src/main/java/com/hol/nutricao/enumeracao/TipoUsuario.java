package com.hol.nutricao.enumeracao;

public enum TipoUsuario {
	ADMINISTRADOR, NUTRICIONISTA, ADMINISTRATIVO;

	@Override
	public String toString() {
		switch (this) {
		case ADMINISTRADOR:
			return "Administrador";
		case NUTRICIONISTA:
			return "Nutricionista";
		case ADMINISTRATIVO:
			return "Administrativo";
		default:
			return null;
		}

	}
}
