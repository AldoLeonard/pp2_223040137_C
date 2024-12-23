package dao;

import java.util.List;
import models.TableUser;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisConfig;

public class TableUserDAO {
    public List<TableUser> getAll() {
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            return session.getMapper(mapper.TableUserMapper.class).getAll();
        }
    }

    public void insert(TableUser tableUser) {
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            session.getMapper(mapper.TableUserMapper.class).insert(tableUser);
            session.commit();
        }
    }

    public void update(TableUser tableUser) {
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            session.getMapper(mapper.TableUserMapper.class).update(tableUser);
            session.commit();
        }
    }

    public void delete(int id) {
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            session.getMapper(mapper.TableUserMapper.class).delete(id);
            session.commit();
        }
    }

    public TableUser getById(int id) {
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            return session.getMapper(mapper.TableUserMapper.class).getById(id);
        }
    }
}

