package daos;

import java.sql.Connection;
import java.util.List;

public abstract class   CarDao<T> {

    protected Connection connection;

    public CarDao(Connection conn){
        this.connection=conn;
    }

    abstract public T findById(int id);
  abstract   public List findAll();
   abstract public T update(T dto);
    abstract public T create(T dto);
    abstract public void delete(int id);


}
