# coding=utf-8

from django.shortcuts import render
from django.http import HttpResponse
from perfis.models import Perfil, Convite
from django.shortcuts import redirect
from django.contrib.auth.decorators import login_required

#declaração da função de view, será chamada pelo Django atraves da rota definida em perfis/urls.py
@login_required
def index(request):
	return render(request, 'index.html', { 'perfis' : Perfil.objects.all(), 
		'perfil_logado' : get_perfil_logado(request)})

@login_required
def exibir(request, perfil_id):
	
	perfil = Perfil.objects.get(id=perfil_id)
	perfil_logado = get_perfil_logado(request)
	ja_eh_contato = perfil in perfil_logado.contatos.all() #verifica se o perfil a ser exibido já esta na lista de contatos do perfil logado
	return render(request, 'perfil.html', {'perfil' : perfil, 'perfil_logado' : get_perfil_logado(request), 
		'ja_eh_contato' : ja_eh_contato})


@login_required
def convidar(request, perfil_id):

	perfil_a_convidar = Perfil.objects.get(id=perfil_id)
	perfil_logado = get_perfil_logado(request)
	perfil_logado.convidar(perfil_a_convidar)

	return redirect('index')


@login_required
def get_perfil_logado(request):
	return request.user.perfil 


@login_required
def aceitar(request, convite_id):
	convite = Convite.objects.get(id=convite_id)
	convite.aceitar()
	return redirect('index')
