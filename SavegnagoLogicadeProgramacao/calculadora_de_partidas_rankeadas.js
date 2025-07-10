let vitorias = 100
let derrotas = 2
let tier

function calculate(vitorias, derrotas) {
    return vitorias - derrotas
}

if (calculate(vitorias, derrotas) < 10) {
    tier = "Ferro"
}
else if (calculate(vitorias, derrotas) >= 11 && calculate(vitorias, derrotas) < 20) {
    tier = "Bronze"
}
else if (calculate(vitorias, derrotas) >= 21 && calculate(vitorias, derrotas) < 50) {
    tier = "Prata"
}
else if (calculate(vitorias, derrotas) >= 51 && calculate(vitorias, derrotas) < 80) {
    tier = "Ouro"
}
else if (calculate(vitorias, derrotas) >= 81 && calculate(vitorias, derrotas) < 90) {
    tier = "Diamante"
}
else if (calculate(vitorias, derrotas) >= 91 && calculate(vitorias, derrotas) < 100) {
    tier = "Lendário"
}
else if (calculate(vitorias, derrotas) >= 101) {
    tier = "Imortal"
}

console.log("O Herói tem de saldo de " + calculate(vitorias, derrotas) + " está no nível de " + tier)

