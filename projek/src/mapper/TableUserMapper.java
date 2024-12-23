package mapper;

import java.util.List;
import models.TableUser;

public interface TableUserMapper {
    List<TableUser> getAll();
    void insert(TableUser tableUser);
    void update(TableUser tableUser);
    void delete(int id);
    TableUser getById(int id);
}

