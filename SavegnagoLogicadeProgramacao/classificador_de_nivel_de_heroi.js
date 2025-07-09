
let nome = "Álvaro"
let quantidadeDeXP = 10002
let nivel

if (quantidadeDeXP <= 1000){
    nivel = "Ferro"
}
else if (quantidadeDeXP >= 1001 && quantidadeDeXP < 2000 ){
    nivel = "Bronze"
}
else if (quantidadeDeXP >= 2001 && quantidadeDeXP < 5000 ){
    nivel = "Prata"
}
else if (quantidadeDeXP >= 5001 && quantidadeDeXP < 7000 ){
    nivel = "Ouro"
}
else if (quantidadeDeXP >= 7001 && quantidadeDeXP < 8000 ){
    nivel = "Platina"
}
else if (quantidadeDeXP >= 8001 && quantidadeDeXP < 9000 ){
    nivel = "Ascendente"
}
else if (quantidadeDeXP >= 9001 && quantidadeDeXP < 10000 ){
    nivel = "Imortal"
}
else if (quantidadeDeXP >= 10001){
    nivel = "Radiante"
}

console.log("O Herói de nome " + nome + " está no nível de " + nivel)