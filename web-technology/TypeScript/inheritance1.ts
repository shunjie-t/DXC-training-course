export {}

class Trainee {
    // public by default
    traineeName : string;

    constructor(name:string) {
        this.traineeName = name;
    }

    display() {
        console.log(`Hello ${this.traineeName}`);
    }
}

class JrTrainee extends Trainee {
    constructor(jrName:string) {
        super(jrName);
    }

    receiveKT() {
        console.log(`KT in progress!! from ${this.traineeName}`);
    }
}

var t = new Trainee("Akhil");
console.log(t.traineeName);
t.display();

var jrt = new JrTrainee("Remo");
console.log(jrt.traineeName);
jrt.display();
jrt.receiveKT();