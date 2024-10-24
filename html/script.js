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

function exibirTexto(texto) {
  resposta = texto;
  typeWritter();
}
function typeWritter(){
  if(i < resposta.length) {
    document.getElementById('resposta').innerHTML += resposta.charAt(i);
    i++;
    setTimeout(typeWritter, velocidade);
  }
}

function limparDados(){
  i = 0;
  document.getElementById('resposta').innerHTML = ""; 
}

function buscarGPT(prompt){
  limparDados();
  alert(prompt);
  const url = "https://api.openai.com/v1/chat/completions";
  const headers = {
    "Content-Type": "application/json",
    "Authorization": `Bearer sk-EfCVEwoWisZmWEtu-YYmRJeIRjkJnAXEnC6VBKW-YoT3BlbkFJe6cwJTmc84VtIkxunzhdoclgoiOjmTKoqiC_E7RFAA`
  };
  const body = JSON.stringify({
      model: "gpt-4",
      messages: [{ role: "user", content: prompt }],
      temperature: 0.7,
      max_tokens: 100
  });

  fetch(url, {
    method: "POST",
    headers: headers,
    body: body
  }).then(res => res.json())
  .then(resp => exibirTexto(resp.choices[0].message.content))
  .catch(err => console.error("Erro ao buscar na API:", err));

}

async function perguntaChatGPT(prompt){
    const url = "https://api.openai.com/v1/chat/completions";
    console.log('passou 1');
    const headers = {
        "Content-Type": "application/json",
        "Authorization": `Bearer sk-EfCVEwoWisZmWEtu-YYmRJeIRjkJnAXEnC6VBKW-YoT3BlbkFJe6cwJTmc84VtIkxunzhdoclgoiOjmTKoqiC_E7RFAA`
    };
    console.log('passou 2');
    const body = JSON.stringify({
        model: "gpt-4",
        messages: [{ role: "user", content: prompt }],
        temperature: 0.7,
        max_tokens: 100
    });
    console.log('passou 3');
    try {
      console.log('passou 4');
        const response = await fetch(url, {
            method: "POST",
            headers: headers,
            body: body
        });
        console.log('passou 5 ' + response);
        if (!response.ok) {
            throw new Error(`Erro na requisição: ${response.statusText}`);
        }

        const data = await response.json();
        console.log("Resposta da API:", data.choices[0].message.content);
        //return data.choices[0].message.content;
        return data.choices[0].message.content;
    } catch (error) {
        console.error("Erro ao buscar na API:", error);
        return "Erro ao buscar na API: " + error;
        //return null;
    }

  //
}