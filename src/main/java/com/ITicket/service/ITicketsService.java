/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ITicket.service;

import com.ITicket.entity.ITickets;
import com.ITicket.repository.ITicketsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author XLight
 */
@Service
public class ITicketsService implements IITicketsService{
    @Autowired
    private ITicketsRepository iticketsRepository;
    
    @Override
    public List<ITickets> ListITickets(){
        return (List<ITickets>)iticketsRepository.findAll();
    }
}
