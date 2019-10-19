/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookFay.UI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Qhris
 */
@Entity
@Table(name = "student", catalog = "book_fay", schema = "")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByStdId", query = "SELECT s FROM Student s WHERE s.stdId = :stdId")
    , @NamedQuery(name = "Student.findByStdname", query = "SELECT s FROM Student s WHERE s.stdname = :stdname")
    , @NamedQuery(name = "Student.findByStdpass", query = "SELECT s FROM Student s WHERE s.stdpass = :stdpass")
    , @NamedQuery(name = "Student.findByStdphone", query = "SELECT s FROM Student s WHERE s.stdphone = :stdphone")
    , @NamedQuery(name = "Student.findByStdemail", query = "SELECT s FROM Student s WHERE s.stdemail = :stdemail")
    , @NamedQuery(name = "Student.findByStdmatric", query = "SELECT s FROM Student s WHERE s.stdmatric = :stdmatric")})
public class Student implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "std_id")
    private Integer stdId;
    @Basic(optional = false)
    @Column(name = "stdname")
    private String stdname;
    @Basic(optional = false)
    @Column(name = "stdpass")
    private String stdpass;
    @Basic(optional = false)
    @Column(name = "stdphone")
    private String stdphone;
    @Basic(optional = false)
    @Column(name = "stdemail")
    private String stdemail;
    @Basic(optional = false)
    @Column(name = "stdmatric")
    private String stdmatric;

    public Student() {
    }

    public Student(Integer stdId) {
        this.stdId = stdId;
    }

    public Student(Integer stdId, String stdname, String stdpass, String stdphone, String stdemail, String stdmatric) {
        this.stdId = stdId;
        this.stdname = stdname;
        this.stdpass = stdpass;
        this.stdphone = stdphone;
        this.stdemail = stdemail;
        this.stdmatric = stdmatric;
    }

    public Integer getStdId() {
        return stdId;
    }

    public void setStdId(Integer stdId) {
        Integer oldStdId = this.stdId;
        this.stdId = stdId;
        changeSupport.firePropertyChange("stdId", oldStdId, stdId);
    }

    public String getStdname() {
        return stdname;
    }

    public void setStdname(String stdname) {
        String oldStdname = this.stdname;
        this.stdname = stdname;
        changeSupport.firePropertyChange("stdname", oldStdname, stdname);
    }

    public String getStdpass() {
        return stdpass;
    }

    public void setStdpass(String stdpass) {
        String oldStdpass = this.stdpass;
        this.stdpass = stdpass;
        changeSupport.firePropertyChange("stdpass", oldStdpass, stdpass);
    }

    public String getStdphone() {
        return stdphone;
    }

    public void setStdphone(String stdphone) {
        String oldStdphone = this.stdphone;
        this.stdphone = stdphone;
        changeSupport.firePropertyChange("stdphone", oldStdphone, stdphone);
    }

    public String getStdemail() {
        return stdemail;
    }

    public void setStdemail(String stdemail) {
        String oldStdemail = this.stdemail;
        this.stdemail = stdemail;
        changeSupport.firePropertyChange("stdemail", oldStdemail, stdemail);
    }

    public String getStdmatric() {
        return stdmatric;
    }

    public void setStdmatric(String stdmatric) {
        String oldStdmatric = this.stdmatric;
        this.stdmatric = stdmatric;
        changeSupport.firePropertyChange("stdmatric", oldStdmatric, stdmatric);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdId != null ? stdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.stdId == null && other.stdId != null) || (this.stdId != null && !this.stdId.equals(other.stdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookFay.UI.Student[ stdId=" + stdId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
