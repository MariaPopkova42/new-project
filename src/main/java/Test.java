import ru.sapteh.dao.Dao;

import ru.sapteh.dao.impl.UserDaoImpl;
import ru.sapteh.model.Auto;
import ru.sapteh.utils.Connector;

import java.sql.Connection;

    public class Test {
        public static void main(String[] args){
            Connection connection = Connector.getInstance();
            Dao<Auto, Integer> userDao = new UserDaoImpl(connection);

            //findById
//            System.out.println(userDao.findById(1));

            //findAll
//          userDao.findAll().forEach(System.out::println);

//        userDao.save(new Auto("Mashina", "Putin","Sedan","АИ 100"));

            //update
//        Auto userUpdater = userDao.findById(1);
//        userUpdater.setModel("Arnold");
//        userUpdater.setMark("Schwarzenegger");
//        userUpdater.setBody_type("Kama");
//        userUpdater.setType_gasoline("АИ-95");
//        userDao.update(userUpdater);

            //delete
//        userDao.deleteById(2);


            Connector.close(connection);


        }
    }
