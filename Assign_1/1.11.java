class Instructor {
    String name, phone_number;

    String getName() {
        return name;
    }

    String getPhone_number() {
        return phone_number;
    }

    void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    void setName(String name) {
        this.name = name;
    }
    void print(){
        System.out.println("Name: "+name+" phone_number: "+phone_number);
    }
}

class Textbook {
    String author, title, publisher;

    String getAuthor() {
        return author;
    }

    String getPublisher() {
        return publisher;
    }

    void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setAuthor(String author) {
        this.author = author;
    }
    void print(){
        System.out.println("title: "+title+" author: "+author+" Publisher: "+publisher);
    }
}

class Course {
    String course_name;
    Textbook book;
    Instructor i;
    Course(String name){
        course_name=name;
    }
    String getCourse_name() {
        return course_name;
    }

    Textbook getBook() {
        return book;
    }

    void setBook(Textbook book) {
        this.book = book;
    }
    Instructor getI() {
        return i;
    }

    void setI(Instructor i) {
        this.i = i;
    }

    void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
    void print(){
        System.out.println("Course_name: "+course_name);
        book.print();
        i.print();
    }


    public static void main(String[] args) {
        Textbook t=new Textbook();
        t.setAuthor("Doyle");
        t.setPublisher("abc");
        t.setTitle("sherlock");
        Course c=new Course("Literature");
        c.setBook(t);
        Instructor i=new Instructor();
        i.setName("piSigma");
        i.setPhone_number("987654321");
        c.i=i;
        c.print();

    }

}