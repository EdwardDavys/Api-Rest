package com.david.sanchez.apirest.mapper;

public interface IMapper <I,O>{
    O map(I in);
}
