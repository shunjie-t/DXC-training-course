function func1(param1, param2) {
    console.log("Function 1 without any data type declaration.");
    console.log("Parameter 1: " + param1 + " Parameter 2: " + param2);
}

func1("string argument", true);

function func2(param1 : string, param2 : number) {
    console.log("Function 2 with parameter data type declaration.")
    console.log("Parameter 1: " + param1 + " Parameter 2: " + param2);
}

var func3 = (param1:string, param2:string) : string => {
    console.log("Function 3 with parameter and return data type declaration.")
    return param1 + " " + param2;
};

function func4(param : number, default_param : number = 4, optional_param? : number) : number {
    return param + default_param + optional_param;
}