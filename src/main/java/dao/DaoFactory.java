package dao;

import dao.impl.CidadeDaoImpl;
import dao.impl.HotelDaoImpl;
import dao.impl.PacoteDaoImpl;
import dao.impl.RestauranteDaoImpl;

public class DaoFactory {

	public static CidadeDao criarCidadeDao() {
		return new CidadeDaoImpl();
	}

	public static HotelDao criarHotelDao() {
		return new HotelDaoImpl();
	}

	public static PacoteDao criarPacoteDao() {
		return new PacoteDaoImpl();
	}

	public static RestauranteDao criarRestauranteDao() {
		return new RestauranteDaoImpl();
	}
}
