package com.pis.dao;

import com.pis.model.Maerz;

public interface MaerzDao {
	public void updateVelinar(Maerz entity);
	public void updateStrojnik(Maerz entity);
	public void updateVeduci(Maerz entity);
	public double getG23(int mesiac);
	public double getG24(int mesiac);
	public double getG25(int mesiac);
	public double getF36(int mesiac);
	public double getG36(int mesiac);
}
