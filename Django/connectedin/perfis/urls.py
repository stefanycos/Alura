# coding=utf-8

from django.conf.urls import patterns, include, url
from django.contrib import admin
from perfis import views

urlpatterns = patterns('',
    #index é o apelido usado para pagina, assim quando usarmos no html podemos utilizar esse apelido.
    url(r'^$', views.index, name='index'),

    # Regex do python, onde podemos criar um grupo de regex e nomea-lo
    # Regex pattern: só aceira números e devem vir depois da palara 'perfis': http://127.0.0.1:8000/perfis/2
    url(r'^perfis/(?P<perfil_id>\d+)$', views.exibir, name='exibir'),
    url(r'^perfis/(?P<perfil_id>\d+)/convidar$', views.convidar, name='convidar' ),
    url(r'^convite/(?P<convite_id>\d+)/aceitar$', views.aceitar, name='aceitar')

)