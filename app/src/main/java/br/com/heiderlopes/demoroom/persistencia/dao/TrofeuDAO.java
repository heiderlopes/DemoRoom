package br.com.heiderlopes.demoroom.persistencia.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.heiderlopes.demoroom.persistencia.entidades.Trofeu;

@Dao
public interface TrofeuDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void adicionar(Trofeu... trofeu);

    @Query("SELECT * FROM trofeu WHERE userId = :userId")
    List<Trofeu> buscaTrofeuPor(int userId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void atualizaTrofeu(Trofeu... trofeu);

    @Query("delete from trofeu where id = :id")
    void delete(long id);

}
