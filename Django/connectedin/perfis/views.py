# coding=utf-8

from django.shortcuts import render, redirect
from perfis.models  import Perfil

#declaração da função de view, será chamada pelo Django atraves da rota definida em perfis/urls.py
def index(request):
    #perfis: nome do template | Perfil.objects.all(): dicionario com os dados que serão dispinibilizados no template
    return render(request, 'index.html',  { 'perfis': Perfil.objects.all() })

def exibir(request, perfil_id):
    print('ID Perfil recebido: ', perfil_id)
    perfil = Perfil.objects.get(id=perfil_id)
    
    return render(request, 'perfil.html', { "perfil": perfil })

def convidar(request, perfil_id):
    perfil_a_convidar = Perfil.objects.get(id=perfil_id)
    perfil_logado = get_perfil_logado(request)
    perfil_logado.convidar(perfil_a_convidar)
    return redirect('index')

def get_perfil_logado(request):
    return Perfil.objects.get(id=1)

