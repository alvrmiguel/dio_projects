saldo = 0
limite = 500
extrato_movimentacoes = ""
numero_saques = 0
LIMITE_SAQUES = 3

# Lista vazia para armazenar os usuários e as contas
lista_usuarios = []
lista_contas = []
# Definição da agência fixa
AGENCIA = "0001"

def criar_usuario(usuarios):
    nome = input("Digite o nome do usuário: ")
    data_nascimento = input("Digite a data de nascimento (DD/MM/AAAA): ")
    cpf = input("Digite o CPF: ")
    endereco = input("Digite o endereço (logradouro-bairro-cidade/estado): ")

    # Verifica se o CPF já existe na lista de usuários
    for usuario in usuarios:
        if usuario['cpf'] == cpf:
            print("Erro: Já existe um usuário com esse CPF.")
            return

    # Remove qualquer caractere não numérico do CPF
    cpf_numerico = ''.join(filter(str.isdigit, cpf))

    # Adiciona o usuário à lista
    usuarios.append({'nome': nome, 'data_nascimento': data_nascimento, 'cpf': cpf_numerico, 'endereco': endereco})
    print("Usuário criado com sucesso.")

def criar_conta_corrente(contas, usuarios):
    numero_conta = len(contas) + 1  # Número da conta sequencial
    agencia = AGENCIA
    
    # Verifica se há pelo menos um usuário cadastrado para associar à conta
    if not usuarios:
        print("Erro: Não há usuários cadastrados para associar à conta.")
        return
    
    # Lista os usuários disponíveis para associar à conta
    print("Usuários disponíveis para associação à conta:")
    for i, usuario in enumerate(usuarios, start=1):
        print(f"{i}. {usuario['nome']}")

    # Solicita ao usuário que selecione um usuário para associar à conta
    while True:
        try:
            indice_usuario = int(input("Selecione o número do usuário: ")) - 1
            if 0 <= indice_usuario < len(usuarios):
                break
            else:
                print("Opção inválida. Por favor, selecione um número válido.")
        except ValueError:
            print("Por favor, insira um número válido.")

    # Associa o usuário selecionado à conta
    usuario_associado = usuarios[indice_usuario]
    
    # Adiciona a conta à lista de contas
    contas.append({'agencia': agencia, 'numero_conta': numero_conta, 'usuario': usuario_associado})
    print("Conta corrente criada com sucesso.")


def deposito(valor, /):
    global saldo
    global extrato_movimentacoes
    if valor > 0:
        saldo += valor
        extrato_movimentacoes += f"Depósito: R$ {valor:.2f}\n"
    else:
        print("Operação falhou! O valor informado é inválido.")

def saque(*, valor):
    global numero_saques
    global saldo
    global extrato_movimentacoes
    excedeu_saldo = valor > saldo
    excedeu_limite = valor > limite
    excedeu_saques = numero_saques >= LIMITE_SAQUES

    if excedeu_saldo:
        print("Operação falhou! Você não tem saldo suficiente.")
    elif excedeu_limite:
        print("Operação falhou! O valor do saque excede o limite.")
    elif excedeu_saques:
        print("Operação falhou! Número máximo de saques excedido.")
    elif valor > 0:
        saldo -= valor
        extrato_movimentacoes += f"Saque: R$ {valor:.2f}\n"
        numero_saques += 1
    else:
        print("Operação falhou! O valor informado é inválido.")

def mostrar_extrato(saldo, /, *, extrato):
    print("\n================ EXTRATO ================")
    print("Não foram realizadas movimentações." if not extrato_movimentacoes else extrato_movimentacoes)
    print(f"\nSaldo: R$ {saldo:.2f}")
    print("==========================================")

while True:
    menu = """
    [d] Depositar
    [s] Sacar
    [e] Extrato
    [c] Criar Usuário
    [a] Criar Conta Corrente
    [q] Sair

    => """

    opcao = input(menu)

    if opcao == "d":
        valor = float(input("Informe o valor do depósito: "))
        deposito(valor)
    elif opcao == "s":
        valor = float(input("Informe o valor do saque: "))
        saque(valor=valor)
    elif opcao == "e":
        mostrar_extrato(saldo, extrato=extrato_movimentacoes)
    elif opcao == "c":
        criar_usuario(lista_usuarios)
    elif opcao == "a":
        criar_conta_corrente(lista_contas, lista_usuarios)
    elif opcao == "q":
        break
    else:
        print("Operação inválida, por favor selecione novamente a operação desejada.")
