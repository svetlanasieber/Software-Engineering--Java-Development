function solve(num1, num2, operation) {
  switch (operation) {
    case "+":
      console.log(num1 + num2);
      break;

    case "-":
      console.log(num1 - num2);
      break;

    case "*":
      console.log(num1 * num2);
      break;

    case "/":
      console.log(num1 / num2);
      break;

    case "%":
      console.log(num1 % num2);
      break;

    case "**":
      console.log(num1 ** num2);
      break;
  }
}

solve(5, 6, "+");
