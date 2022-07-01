/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ITicket.service;

import com.ITicket.entity.Conciertos;
import java.util.List;

/**
 *
 * @author XLight
 */
public interface IConciertosService {
    public List<Conciertos> getAllConciertos();
    public Conciertos getConciertosById (long id);
    public void saveConciertos (Conciertos Conciertos);
    public void delete (long id);
    
}
