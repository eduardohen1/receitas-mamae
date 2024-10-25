var resposta = "";
var i = 0;
var velocidade = 50;

function btnEnviar(){
    //alert("Enviar formulário!!!");
    Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "Something went wrong!",
        footer: '<a href="#">Why do I have this issue?</a>'
      });
}

function somar(){
  limparPagina2();
  var valor1 = document.getElementById("valor1").value;
  var valor2 = document.getElementById("valor2").value;
  var resultado = parseFloat(valor1) + parseFloat(valor2);
  Swal.fire("Resultado soma: " + resultado);
  document.getElementById("resultado").innerHTML = "Resultado soma: " + resultado;
}

function subtrair(){
  limparPagina2();
  var valor1 = document.getElementById("valor1").value;
  var valor2 = document.getElementById("valor2").value;

  var resultado = parseFloat(valor1) - parseFloat(valor2);

  Swal.fire("Resultado Subtração: " + resultado);

}

function multiplicar(){
  limparPagina2();
  var valor1 = document.getElementById("valor1").value;
  var valor2 = document.getElementById("valor2").value;
  var resultado = parseFloat(valor1) * parseFloat(valor2);
  Swal.fire("Resultado Multiplicação: " + resultado);
}

function dividir(){
  limparPagina2();
  var valor1 = document.getElementById("valor1").value;
  var valor2 = document.getElementById("valor2").value;
  var resultado = parseFloat(valor1) / parseFloat(valor2);
  Swal.fire("Resultado Divisão: " + resultado);  
}

function limparPagina2(){
  document.getElementById("resultado").innerHTML = "";
}

function limparPagina3(){
  document.getElementById("resposta").innerHTML = "";
}

function enviarPergunta(){
  limparPagina3();
  var prompt = document.getElementById("pergunta").value;
  const url = "https://api.openai.com/v1/chat/completions";
  const headers = {
    "Content-Type": "application/json",
    "Authorization": `Bearer <token_OpenAi>`
  };
  const body = JSON.stringify({
    model: "gpt-4",
    messages: [{role: "user", content: prompt}],
    temperature: 0.7,
    max_tokens: 100
  });
  
  fetch(url, {method: "POST", headers: headers, body: body})
  .then(res => res.json())
  .then(resp => exibirTexto(resp.choices[0].message.content))
  .catch(err => console.error(err));

}
function exibirTexto(texto){
  //document.getElementById("resposta").innerHTML = texto;
  resposta = texto;
  typeWritter();
}

function typWritter(){
  if(i < resposta.length){
    document.getElementById("resposta").innerHTML += resposta.charAt(i);
    i++;
    setTimeout(typeWritter, velocidade);
  }
}