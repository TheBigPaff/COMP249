import java.util.Objects;

public class Grade {
    static final double MIDTERM_WEIGHT = 0.33;
    static final double FINAL_WEIGHT = 0.67;

    private int midtermExamGrade;
    private int finalExamGrade;
    private char grade;

    public Grade(){
        midtermExamGrade = 0; // can't set a primitive type to null, so we'll set it to 0
        finalExamGrade = 0;
        grade = 'N';
        // Evaluate(); why would we invoke it here? it'll change the grade 'N'.
    }

    public Grade(Grade gradeObject){
        midtermExamGrade = gradeObject.midtermExamGrade;
        finalExamGrade = gradeObject.finalExamGrade;
        grade = gradeObject.grade;
        Evaluate();
    }

    public Grade (int midtermGrade, int finalGrade, char grade){
        setMidtermExamGrade(midtermGrade);
        setFinalExamGrade(finalGrade);
        setGrade(grade);
        Evaluate();
    }

    // MUTATOR METHODS
    public void setMidtermExamGrade(int midtermExamGrade) {
        if(midtermExamGrade < 0) this.midtermExamGrade = 0;
        else if(midtermExamGrade > 100) this.midtermExamGrade = 100;
        else this.midtermExamGrade = midtermExamGrade;
    }
    public void setFinalExamGrade(int finalExamGrade) {
        if(finalExamGrade < 0) this.finalExamGrade = 0;
        else if(finalExamGrade > 100) this.finalExamGrade = 100;
        else this.finalExamGrade = finalExamGrade;
    }
    public void setGrade(char grade) {
        this.grade = grade;
    }

    // ACCESSOR METHODS
    public int getMidtermExamGrade() {
        return midtermExamGrade;
    }
    public int getFinalExamGrade() {
        return finalExamGrade;
    }
    public char getGrade() {
        return grade;
    }

    // METHODS
    private void Evaluate(){
        double weightedAverage = midtermExamGrade * MIDTERM_WEIGHT + finalExamGrade * FINAL_WEIGHT;
        grade = weightedAverage >= 60 ? 'P' : 'F';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false; // check if obj is null or not a Grade object
        Grade grade1 = (Grade) obj; // cast to Grade
        return midtermExamGrade == grade1.midtermExamGrade && finalExamGrade == grade1.finalExamGrade && grade == grade1.grade;
    }

    @Override
    public String toString() {
        return String.format("Midterm Exam Grade: %d\nFinal Exam Grade: %d\nGrade: %c", midtermExamGrade, finalExamGrade, grade);
    }
}
