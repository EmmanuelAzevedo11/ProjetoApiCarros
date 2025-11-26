/*CRIANDO A REQUISIÇÃO GET */

(async function chamando() {
    try{
        const headers = {
            'Content-Type' : 'application/json'
        }
        const init = {
            method: 'GET',
            headers: headers
        }
        const responseGet = await fetch("http://localhost:8080/carros",
            {
                init
            }
        );
        
        
        
        if (!responseGet.ok) {
            throw new Error("Erro HTTP: " + responseGet.status);
         }

        const response = await responseGet.json();
        response.forEach(car => {
            
            //declarando as divs e seus filhos
            let container = document.getElementById('carsLook');

            let divPai = document.createElement('div');
            divPai.classList.add('divPai');
            
            let marca = document.createElement('h1');
            marca.textContent = `${car.marca}`;
            marca.classList.add('marca');

            
            let modelo = document.createElement('h4');
            modelo.textContent = `${car.modelo}`;
            modelo.classList.add('modelo');

            let km = document.createElement('p');
            km.innerHTML = `Km: <br>`+  + String(car.quilometragem);;
            km.classList.add('km');

            let ano = document.createElement('p');
            ano.innerHTML = `Ano: <br>` + String(car.ano);
            ano.classList.add('ano');

            container.appendChild(divPai);

            divPai.appendChild(marca);
            divPai.appendChild(modelo);


            let divFilha = document.createElement('div');
            divFilha.classList.add('divFilha');

            divPai.appendChild(divFilha);
            divFilha.appendChild(km);
            divFilha.appendChild(ano);

            let botaoEditar = document.createElement('button');

            botaoEditar.addEventListener("click", () => {
                window.location.href = `edit.html?id=${car.id}`;
            });

            botaoEditar.textContent = "Editar";
            botaoEditar.classList.add('botaoEditar');
            divPai.appendChild(botaoEditar);
        });
        
        

    } catch(e){
        console.log("Deu erro: " + e);
    }
})();


document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('form');
    
    form.addEventListener('submit', (event) => {
        event.preventDefault(); 

        criarCarro(form); 
    });

  
    async function criarCarro(formElement) { 

        const dadosCarro = {
            'marca': document.getElementById('marca').value,
            'modelo': document.getElementById('modelo').value,
            'quilometragem': parseInt(document.getElementById('km').value),
            'ano': parseInt(document.getElementById('ano').value)          
        };
        document.getElementById('marca').value = '';
        document.getElementById('modelo').value = '';
        document.getElementById('km').value = '';
        document.getElementById('ano').value = '';
            
        try {
            const headers = {
                'Content-Type' : 'application/json'
            };
            
            const init = {
                method: 'POST',
                headers: headers,
                body: JSON.stringify(dadosCarro)
            };

            const responsePost = await fetch("http://localhost:8080/carros", init);
            
            if (!responsePost.ok) {
                console.log("Deu erro na hora de criar o carro");
            }

            const novoCarro = await responsePost.json();
            console.log("Carro criado");
            
        } catch(e) {
            console.log("Error: " + e);
        }
    }
})





// const reponseGet = fetch("http://localhost:8080/carros")
//     .then(function (reponse) {
//        return reponse.json();
//     })
//     .then(function (carrosJson) {
//         console.log(carrosJson);
//     })
//     .catch(function (error) {
//         console.log("Erro ao fazer a requisição para a Api: " + error);
//     })