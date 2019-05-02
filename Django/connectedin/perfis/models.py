# coding=utf-8

from django.db import models

class Perfil(models.Model):

    #modelo a ser persistido no banco de dados
    nome = models.CharField(max_length=255, null=False)
    email = models.CharField(max_length=255, null=False)
    telefone = models.CharField(max_length=15, null=False)
    nome_empresa = models.CharField(max_length=255, null=False)


    def convidar(self, perfil_convidado):
        convite = Convite(solicitante=self, convidado=perfil_convidado)
        convite.save()

class Convite(models.Model):
    #related_name='convites_feitos': serve para deixar o relacionamento entre perfil e Convite bidirecional
    # assim é possivel acessar os convites pelo perfil
    solicitante = models.ForeignKey(Perfil, related_name='convites_feitos')
    convidado = models.ForeignKey(Perfil, related_name='convites_recebidos')
