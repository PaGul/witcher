/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import witcher.entities.ad;
import witcher.entities.bestiary;
import witcher.entities.creditcard;
import witcher.entities.guest;
import witcher.entities.witcherorders;

/**
 *
 * @author pavelgulaev
 */
@Stateless
public class MonsterBean {

    @PersistenceContext(unitName = "VedmakJSFPU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public List<bestiary> getMonsters() {
        TypedQuery<bestiary> query = em.createNamedQuery("bestiary.findAll", bestiary.class);
        return query.getResultList();
    }
    
    public Boolean checkIfMonsterExists(String query) {
        return getMonsterById(query) != null;
    }
    
    public bestiary getMonsterById(String idStr) {
        Integer id = 0;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {

        }
        return em.find(bestiary.class, id);
    }

}