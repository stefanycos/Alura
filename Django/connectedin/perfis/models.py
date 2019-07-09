# coding=utf-8

from django.db import models
from django.contrib.auth.models import User

class Perfil(models.Model):

    #modelo a ser persistido no banco de dados
    nome = models.CharField(max_length=255, null=False)
    telefone = models.CharField(max_length=15, null=False)
    nome_empresa = models.CharField(max_length=255, null=False)
    
    #se relaciona com ele mesmo
    contatos = models.ManyToManyField('self') 

    #relacionamento bidirecional, perfil pode usar user e user pode usar perfil
    usuario = models.OneToOneField(User, related_name="perfil")

    #o email poderá ser acessado atraves de perfil.email, mas na verdade estamos acessando perfil.usuario.email
    @property
    def email(self):
        return self.usuario.email

    def convidar(self, perfil_convidado):
        convite = Convite(solicitante=self, convidado=perfil_convidado)
        convite.save()

class Convite(models.Model):
    #related_name='convites_feitos': serve para deixar o relacionamento entre perfil e Convite bidirecional
    # assim é possivel acessar os convites pelo perfil
    solicitante = models.ForeignKey(Perfil, related_name='convites_feitos')
    convidado = models.ForeignKey(Perfil, related_name='convites_recebidos')

    def aceitar(self):
        self.convidado.contatos.add(self.solicitante)
        self.solicitante.contatos.add(self.convidado) 
        self.delete()
