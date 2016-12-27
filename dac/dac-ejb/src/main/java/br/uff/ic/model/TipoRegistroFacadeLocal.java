/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.TipoRegistro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zideon
 */
@Local
public interface TipoRegistroFacadeLocal {

    void create(TipoRegistro tipoRegistro);

    void edit(TipoRegistro tipoRegistro);

    void remove(TipoRegistro tipoRegistro);

    TipoRegistro find(Object id);

    List<TipoRegistro> findAll();

    List<TipoRegistro> findRange(int[] range);

    int count();
    
}
