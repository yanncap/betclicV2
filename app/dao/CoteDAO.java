package dao;

import models.Cote;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public enum CoteDAO implements DAO<Cote> {
    INSTANCE;

    @Override
    public List<Cote> findAll() {
        return Cote.findAll();
    }

    @Override
    public Cote get(Long id) {
        return Cote.findById(id);
    }

    @Override
    public void save(Cote type) throws HibernateException {
        type.save();
    }

    @Override
    public void update(Cote type) {
        //type.edit();
    }

    @Override
    public void delete(Long id) {
        Cote.delete("id = ?1", id);
    }

    @Override
    public void delete(Cote type) {
        //Cote.de
    }
}
