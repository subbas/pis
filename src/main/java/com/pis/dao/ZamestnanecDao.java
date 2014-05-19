package com.pis.dao;

import java.util.List;

import com.pis.model.Zamestnanec;

public interface ZamestnanecDao {
	public List<Zamestnanec> getAllStrojnik();
	public List<Zamestnanec> getAllVelinar();
	public List<Zamestnanec> getAllMajster();
}
