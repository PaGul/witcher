/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.web;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import witcher.ejbs.GuestBean;
import witcher.ejbs.MonsterBean;
import witcher.entities.bestiary;
import witcher.entities.guest;
import witcher.util.SessionUtils;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@RequestScoped
public class monster_profile implements Serializable{
    
    @EJB
    private MonsterBean monsterBean;
    
    bestiary Monster;
    
    public String getQuery() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("monster");
    }
    
    public void checkIfQueryExists() throws IOException {
        if (!monsterBean.checkIfMonsterExists(getQuery())) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
        } else {
            Monster = monsterBean.getMonsterById(getQuery());
        }
    }
    
    public bestiary getMonster() {
        return Monster;
    }
    
    
    public String getDescription() {
        if (Monster.getDescription()==null) {
            return "No description";
        } else {
            return Monster.getDescription();
        }
    }
    
    public Boolean hasPhoto() {
        return (Monster.getPhoto()!=null);
    }
    
}


