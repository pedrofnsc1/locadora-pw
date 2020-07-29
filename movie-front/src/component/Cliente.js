import React from "react";
import {List, Datagrid, TextField, EmailField, Create, 
        Edit, SimpleForm, TextInput, ArrayField, SingleFieldList, 
        ChipField, EditButton, ArrayInput, SimpleFormIterator, 
        DateInput} from "react-admin";

import { Typography} from '@material-ui/core';
export const ListarCliente = props => (
  <List {...props}>

    <Datagrid>
      <TextField source="pnome" label="Nome"/>
      <TextField source="unome" label="Sobrenome"/>
      <EmailField source="email" label="Email"/>

      <TextField source="telefone" label="Telefone"/>
      <TextField source="endereco.rua" label="Rua"/>
      <TextField source="endereco.numero" label="Numero"/>

        <ArrayField  source="pedidos" label="Dia dos Pedidos">
          <SingleFieldList>
            <ChipField source="dataPedido" label="Dia dos Pedidos"/>
          </SingleFieldList>
        </ArrayField>
        <ArrayField  source="pedidos" label="Hora do Pedidos">
          <SingleFieldList>
            <ChipField source="horaPedido" label="Hora do Pedidos"/>
          </SingleFieldList>
        </ArrayField>    
        <EditButton/>
    </Datagrid>
  </List>
);

const redirect = (basePath, id, data) => `/cliente`;

const validacaoCliente = values => {
  const errors = {};
  if (!values.pnome) {
    errors.pnome = ['Nome é necessário'];
  }
  if(!values.unome){
    errors.unome = ['Sobrenome é necessário'];
  }
  if(!values.email){
    errors.email = ['Email é necessário'];
  }
  if(!values.telefone){
    errors.telefone = ['Telefone é necessário'];
  }
  return errors
};

export const CriarCliente = props => (
  <Create {...props}>
    <SimpleForm redirect={redirect} submitOnEnter={true} validate={validacaoCliente}>
    <Typography variant="h6" gutterBottom>cliente</Typography>
      <TextInput source="pnome" label="Nome"/>
      <TextInput source="unome" label="Sobrenome"/>
      <TextInput source="email" label="Email"/>
      <TextInput source="telefone" label="Telefone"/>

    <Typography variant="h6" gutterBottom>Endereço</Typography>
      <TextInput source="endereco.rua" label="Rua"/>
      <TextInput source="endereco.numero" label="Numero"/>
      <TextInput source="endereco.cidade" label="Cidade"/>
      <TextInput source="endereco.complemento" label="Complmento"/>

    <Typography variant="h6" gutterBottom>Pedido</Typography>
      <ArrayInput source="pedidos">
        <SimpleFormIterator>
          <DateInput source="dataPedido" label="Data do Pedido"/>
          <TextInput source="horaPedido" label="Hora da realização"/>
          <TextInput source="descricao" label="Descrição"/>
      </SimpleFormIterator>
      </ArrayInput>
    </SimpleForm>
  </Create>
);

export const EditarCliente = props => (
  <Edit {...props}>
    <SimpleForm redirect={redirect} submitOnEnter={true} validate={validacaoCliente}>
    <Typography variant="h6" gutterBottom>cliente</Typography>
      <TextInput disabled source="id" label="ID"/>
      <TextInput source="pnome" label="Nome"/>
      <TextInput source="unome" label="Sobrenome"/>
      <TextInput source="email" label="Email"/>
      <TextInput source="telefone" label="Telefone"/>

    <Typography variant="h6" gutterBottom>Endereço</Typography>
      <TextInput source="endereco.rua" label="Rua"/>
      <TextInput source="endereco.numero" label="Numero"/>
      <TextInput source="endereco.cidade" label="Cidade"/>
      <TextInput source="endereco.complemento" label="Complmento"/>

      <Typography variant="h6" gutterBottom>Pedido</Typography>
      <ArrayInput source="pedidos">
        <SimpleFormIterator>
          <DateInput source="dataPedido" label="Data do Pedido"/>
          <TextInput source="horaPedido" label="Hora da realização"/>
          <TextInput source="descricao" label="Descrição"/>
      </SimpleFormIterator>
      </ArrayInput>
    </SimpleForm>
  </Edit>
)