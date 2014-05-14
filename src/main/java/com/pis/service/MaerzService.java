package com.pis.service;

import java.util.List;

import com.pis.model.Maerz;

public interface MaerzService {
	public void add(Maerz entity);
	public void update(Maerz entity);
	public void updateVelinar(Maerz entity);
	public void updateStrojnik(Maerz entity);
	public void updateVeduci(Maerz entity);
	public Maerz getEntity(int id);
	public void delete(int id);
	public List<Maerz> getEntities();
	public int getLastId();
	public double getG23(int mesiac);
	public double getG24(int mesiac);
	public double getG25(int mesiac);
	public double getF36(int mesiac);
	public double getG36(int mesiac);
}
