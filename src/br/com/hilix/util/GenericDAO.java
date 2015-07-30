package br.com.hilix.util;

import java.io.Serializable;
import java.util.List;

interface GenericDAO < T, ID extends Serializable >{

       T   findByPrimaryKey( ID id);
List < T > findAll(int startIndex, int fetchSize);
T save( T entity);
void delete( T entity);
void beginTransaction();
void commitTransaction();
}