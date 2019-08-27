package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.UserDao;
import ru.tampashev.shop.entities.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDaoImpl extends AbstractGenericDao<UserEntity> implements UserDao {

    public UserDaoImpl() {
        type = UserEntity.class;
    }

    @Override
    public UserEntity findByMailAddress(String mailAddress) {
        return getSession()
                    .createNamedQuery("user-find-by-email", type)
                    .setParameter("mailAddress", mailAddress)
                    .uniqueResult();
    }

    @Override
    public Integer find(UserEntity userEntity) {
        UserEntity existedUser = getSession()
                                    .createNamedQuery("user-find-by-email", type)
                                    .setParameter("mailAddress", userEntity.getMailAddress())
                                    .uniqueResult();

        return existedUser != null ? existedUser.getId() : -1;
    }


    @Override
    public List<UserEntity> getTopTenUsers() {
        String query =  "SELECT orderEntity.user, SUM(orderEntity.totalPrice) AS totalSum " +
                        "FROM OrderEntity orderEntity " +
                        "GROUP BY orderEntity.user " +
                        "ORDER BY totalSum DESC";

        List<Object[]> result = getSession().createQuery(query).setMaxResults(10).list();
        return result.stream().map(objects -> (UserEntity)objects[0]).collect(Collectors.toList());
    }
}
