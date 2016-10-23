package com.dena.service;

import java.util.List;


import com.dena.entities.Diaporama;;

public interface IDiaporamaService {
	
	public Diaporama save(Diaporama ex) ;
	public List<Diaporama> findAll() ;
	public Diaporama findById(long id) ;
	public void delete(long id) ;
	public Diaporama update(long id,Diaporama competence);

}
