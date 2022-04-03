package Exer1;

class Employee {
    int age;
    String name;
    double salary;
    String position;
    String department;
    String email;

    public Employee(String[] line) {
        this.name = line[0];
        this.salary = Double.parseDouble(line[1]);
        this.position = line[2];
        this.department = line[3];
        if(line.length>4){
            if(Character.isLetter(line[4].charAt(0))){
                this.email = line[4];
                if(line.length>5){
                    this.age = Integer.parseInt(line[5]);
                } else {
                    this.age = -1;
                }
            } else{
                this.email = "n/a";
                this.age = Integer.parseInt(line[4]);
            }
        } else {
            this.email = "n/a";
            this.age = -1;
        }


    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }
}
