package cn.wxf.score.entity;

public class Score {
    String studentId;
    String teacherId;
    String subject;
    float score;
    String teacherName;
    String studentName;

    public Score(){}

    public Score(String studentId,String teacherId,String subject){
        this.studentId=studentId;
        this.teacherId=teacherId;
        this.subject=subject;
    }

    public Score(String studentId,String teacherId,String subject,float score){
        this.studentId=studentId;
        this.teacherId=teacherId;
        this.subject=subject;
        this.score=score;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "studentId"+studentId+"\tteacherId:"+teacherId+"\tsubject:"+subject+"\tscore:"+score;
    }
}
