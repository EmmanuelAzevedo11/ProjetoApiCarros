const params = new URLSearchParams(window.location.search);
const id = params.get('id');
console.log(id);

async function put(event) {
    event.preventDefault();
    try{
        
        
        const dadosCarro = {
            'marca': document.getElementById('marca').value,
            'modelo': document.getElementById('modelo').value,
            'quilometragem': parseInt(document.getElementById('km').value),
            'ano': parseInt(document.getElementById('ano').value)
        }

            const headers = {
                'Content-Type' : 'application/json'
            };

             const init = {
                method: 'PUT',
                headers: headers,
                body: JSON.stringify(dadosCarro)
            };

            const responsePut = await fetch(`http://localhost:8080/carros/${id}`, init);

            if (!responsePut.ok) {
                console.log("Erro na hora de enviar");
                let pError = document.getElementById('error');
                pError.style.color = 'red';
                pError.textContent = "Certifique que nenhuma informação está em branco";
            }
            else{
                document.getElementById('marca').value = '';
                document.getElementById('modelo').value = '';
                document.getElementById('km').value = '';
                document.getElementById('ano').value = '';
                console.log("sucesso");
                let pError = document.getElementById('error');
                pError.style.color = 'green';
                pError.textContent = "Sucesso!";
                
            }
    }catch(exception){
        console.log(exception);
    }
};

async function del(event) {
    event.preventDefault();
    try{
             const init = {
                method: 'DELETE',
            };

            const responseDelete = await fetch(`http://localhost:8080/carros/id/${id}`, init);
            let pDelete = document.getElementById('responseDelete');

            if(!responseDelete.ok){
                console.log("Erro na hora de deletar");
                
                pDelete.style.color = 'red';
                pDelete.textContent = "Erro";
            } else{
                console.log("Sucesso na hora de deletar");
                pDelete.style.color = 'green';
                pDelete.textContent = 'Sucesso!';

                setTimeout(() => {
                    window.location = "index.html";
                }, 1000);

                
            }

    }catch(exception){
        console.log("Erro geral");
    }
}

