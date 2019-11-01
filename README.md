#API Usuários

##Consultar Usuários Ativos
- Caminho: /api/usuarios/ativos

##Consultar Usuários Inativos
- Caminho: /api/usuarios/inativos

##Consultar Usuário por ID
- Caminho: /api/usuario/{id}
- Se consultar um usuário deletado, retornará erro 404

##Consultar Todos os Usuários
- Caminho: /api/usuarios

##Incluir Usuário
- Caminho: /api/usuario
- CPF deve ser válido
- Usuário não pode ser menor de 18 anos

##Deletar Usuário
- Caminho: /api/usuario/{id}
- Campo deletado será alterado para "true"

##Atualizar Usuário
- Caminho: /api/usuario/{id}
- CPF deve ser válido
- Usuário não pode ser menor de 18 anos
