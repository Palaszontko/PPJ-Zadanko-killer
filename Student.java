class Student {
    String name;
    String surname;
    int s;

    public Student(String name, String surname, int s) {
        this.name = name;
        this.surname = surname;
        this.s = s;
    }

    // if returs true students are in wrong order
    public static Boolean compare(Student student1, Student student2) {

        int val_surname = student1.surname.compareTo(student2.surname);

        if (val_surname > 0) {
            return true;

        } else if (val_surname == 0) {
            int val_name = student1.name.compareTo(student2.name);

            if (val_name > 0) {
                return true;
            } else if (val_name == 0) {
                if (student1.s < student2.s) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Student otherStudent = (Student) obj;

        return this.name.equals(otherStudent.name) &&
                this.surname.equals(otherStudent.surname) &&
                this.s == otherStudent.s;
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + " " + this.s;
    }
}

class Consumer {
    public void accept(Student student) {
        // System.out.println("Accepted: " + student);
    }
}

class ArrayBuilder extends Consumer {
    private Student[] array = new Student[0];

    public void accept(Student student) {
        Student array_temp[] = new Student[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            array_temp[i] = array[i];
        }

        array_temp[array.length] = student;

        array = array_temp;
    }

    public Student[] getStudents() {
        return array;
    }
}

class IndexFinder extends Consumer {
    public Student student;
    private int s;

    public IndexFinder(int s) {
        this.s = s;
    }

    public void accept(Student student) {
        if (student.s == this.s) {
            this.student = student;
        }
    }

    public Student getTrackedStudent() {
        return student;
    }
}


class MinFinder extends Consumer {
    public Student student;
    private int s;

    public MinFinder() {
        this.s = Integer.MAX_VALUE;
    }

    public void accept(Student student) {
        if (student.s < this.s) {
            this.student = student;
            this.s = student.s;
        }
    }

    public Student getTrackedStudent() {
        return student;
    }
}

class MaxFinder extends Consumer {
    public Student student;
    private int s;

    public MaxFinder() {
        this.s = Integer.MIN_VALUE;
    }

    public void accept(Student student) {
        if (student.s > this.s) {
            this.student = student;
            this.s = student.s;
        }
    }

    public Student getTrackedStudent() {
        return student;
    }
}