package ua.netcrackerteam.util.xls.entity;


import javax.persistence.*;

/**
 * @author unconsionable
 */
@Entity(name = "XlsUserInfo")
public class XlsUserInfo implements XlsEntity {
    @Id
    @Column(name = "number2")
    protected String number2;
    @Column(name = "surname")
    protected String surname;
    @Column(name = "name")
    protected String name;
    @Column(name = "secondName")
    protected String secondName;
    @Column(name = "finalResult")
    protected String finalResult;
    @Column(name = "hr1")
    protected String hr1;
    @Column(name = "result1")

    protected String result1;
    @Column(name = "comment1")
    protected String comment1;
    @Column(name = "hr2")
    protected String hr2;
    @Column(name = "result2")
    protected String result2;
    @Column(name = "comment2")
    protected String comment2;
    @Column(name = "javaKnowledge")
    protected String javaKnowledge;
    @Column(name = "sqlKnowledge")
    protected String sqlKnowledge;
    @Column(name = "cource")
    protected String cource;
    @Column(name = "averageHighSchoolGrade")
    protected String averageHighSchoolGrade;
    @Column(name = "speciality")
    protected String speciality;
    @Column(name = "highSchoolName")
    protected String highSchoolName;
    @Column(name = "email1")
    protected String email1;
    @Column(name = "email2")
    protected String email2;
    @Column(name = "telNumber")
    protected String telNumber;

    public String getJavaKnowledge() {
        return javaKnowledge;
    }

    public void setJavaKnowledge(String javaKnowledge) {
        this.javaKnowledge = javaKnowledge;
    }

    public String getSqlKnowledge() {
        return sqlKnowledge;
    }

    public void setSqlKnowledge(String sqlKnowledge) {
        this.sqlKnowledge = sqlKnowledge;
    }

    public XlsUserInfo() {

    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(String finalResult) {
        this.finalResult = finalResult;
    }

    public String getHr1() {
        return hr1;
    }

    public void setHr1(String hr1) {
        this.hr1 = hr1;
    }

    public String getResult1() {
        return result1;
    }

    public void setResult1(String result1) {
        this.result1 = result1;
    }

    public String getComment1() {
        return comment1;
    }

    public void setComment1(String comment1) {
        this.comment1 = comment1;
    }

    public String getHr2() {
        return hr2;
    }

    public void setHr2(String hr2) {
        this.hr2 = hr2;
    }

    public String getResult2() {
        return result2;
    }

    public void setResult2(String result2) {
        this.result2 = result2;
    }

    public String getComment2() {
        return comment2;
    }

    public void setComment2(String comment2) {
        this.comment2 = comment2;
    }

    public String getCource() {
        return cource;
    }

    public void setCource(String cource) {
        this.cource = cource;
    }

    public String getAverageHighSchoolGrade() {
        return averageHighSchoolGrade;
    }

    public void setAverageHighSchoolGrade(String averageHighSchoolGrade) {
        this.averageHighSchoolGrade = averageHighSchoolGrade;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getHighSchoolName() {
        return highSchoolName;
    }

    public void setHighSchoolName(String highSchoolName) {
        this.highSchoolName = highSchoolName;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}