<template>
    <div class="painel">
        <!-- @dblclick substitui o v-on -->
        <h2 class="painel-titulo" @dblclick="visivel = !visivel">{{ titulo }}</h2>
        <transition name="painel-fade">
            <div class="painel-conteuto" v-show="visivel">
                <slot><!-- será preenchidopelo componente que o utilizalo --></slot>
            </div>
        </transition>
    </div>
</template>

<script>
    export default {
        //array de propriedades que esse componente aceita receber
        //poderão ser usados no html acima
        props: ['titulo'],

        data() {
            return {
                visivel: true
            }
        }
    }
</script>

<!-- diz que esse estilo só vai ser aplicado neste componente e não no restante da pagina -->
<style scoped>
  .painel {
    padding: 0 auto;
    border: solid 2px grey;
    display: inline-block;
    margin: 5px;
    box-shadow: 5px 5px 10px grey;
    width: 200px;
    height: 100%;
    vertical-align: top;
    text-align: center;
  }

  .painel .painel-titulo {
    text-align: center;
    border: solid 2px;
    background: lightblue;
    margin: 0 0 15px 0;
    padding: 10px;
    text-transform: uppercase;
  }
  * {
      box-shadow: 5px 5px 5px black;
  }  

  .painel-fade-enter, .painel-fade-leave-active {
      opacity: 0;
  }

  .painel-fade-enter-active ,.painel-fade-leave-active {
      transition: opacity .4s;
  }
</style>