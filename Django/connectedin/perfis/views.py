# coding=utf-8

from django.shortcuts import render, redirect
from perfis.models  import Perfil, Convite

#declaração da função de view, será chamada pelo Django atraves da rota definida em perfis/urls.py
def index(request):
    #perfis: nome do template | Perfil.objects.all(): dicionario com os dados que serão dispinibilizados no template
    return render(request, 'index.html',  { 'perfis': Perfil.objects.all(), 'perfil_logado' : get_perfil_logado(request) })

def exibir(request, perfil_id):
    perfil = Perfil.objects.get(id=perfil_id)
    perfil_logado = get_perfil_logado(request)
    ja_eh_contato = perfil in perfil_logado.contatos.all() #veriica se o perfil a ser exibido já esta na lista de contatos do perfil logado
    
    return render(request, 'perfil.html', { "perfil": perfil, "ja_eh_contato": ja_eh_contato })

def convidar(request, perfil_id):
    perfil_a_convidar = Perfil.objects.get(id=perfil_id)
    perfil_logado = get_perfil_logado(request)
    perfil_logado.convidar(perfil_a_convidar)
    return redirect('index')

def aceitar(request, convite_id):
    convite = Convite.objects.get(id=convite_id)
    convite.aceitar()
    return redirect('index')

def get_perfil_logado(request):
    return Perfil.objects.get(id=3)

