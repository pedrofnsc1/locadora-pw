import React from 'react';
import { Admin, Resource } from 'react-admin';
import jsonServerProvider from 'ra-data-json-server';

import MovieIcon from '@material-ui/icons/Movie';
import AccountBoxIcon from '@material-ui/icons/AccountBox';
import HomeIcon from '@material-ui/icons/Home';
import PlaylistAddIcon from '@material-ui/icons/PlaylistAdd';

import {ListarCliente, CriarCliente, EditarCliente} from "./component/Cliente";
import {ListarEndereco} from "./component/Endereco";
import {ListarPedido, CriarPedido, EditarPedido} from "./component/Pedido";
import {ListarFilme, CriarFilme, EditarFilme} from "./component/Filme";
import {ListarCategoria, CriarCategoria, EditarCategoria} from "./component/Categoria";

const dataProvider = jsonServerProvider('http://localhost:8080');

const App = () => (
  <Admin dataProvider={dataProvider} > 
  
    <Resource name="cliente" list={ListarCliente} create={CriarCliente} edit={EditarCliente} icon={AccountBoxIcon}/> 

    <Resource name="endereco" list={ListarEndereco} icon={HomeIcon}/>

    <Resource name="pedido" list={ListarPedido} create={CriarPedido} edit={EditarPedido} icon={PlaylistAddIcon}/>

    <Resource name="filme" list={ListarFilme} create={CriarFilme} edit={EditarFilme}icon={MovieIcon}/>

    <Resource name="categoria" list={ListarCategoria} create={CriarCategoria} edit={EditarCategoria}/>

  </Admin>
)
export default App;
