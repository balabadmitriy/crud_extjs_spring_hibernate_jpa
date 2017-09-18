package com.camera.of.city.mvc.dao.impl;

import com.camera.of.city.mvc.dao.AbstractDAO;
import com.camera.of.city.mvc.domain.Camera;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CameraDAO extends AbstractDAO<Camera>{
//    private SessionFactory sessionFactory;

    public CameraDAO() {
        super(Camera.class);
    }

    @Transactional
    public Camera getIdDevice(Long idDevice){
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Camera> criteriaQuery = builder.createQuery(Camera.class);
        Root<Camera> cameraRoot = criteriaQuery.from(Camera.class);
        criteriaQuery.select(cameraRoot);
        criteriaQuery.where(builder.equal(cameraRoot.get("idDevice"),String.valueOf(idDevice)));
        List<Camera> cameras = getEntityManager().createQuery(criteriaQuery).getResultList();
        return cameras.get(0);

    }



}
