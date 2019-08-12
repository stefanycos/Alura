<template>
    <nav>
      <ul>
        <li v-for="rota in rotas">
            <router-link :to="rota.path ? route.path : '/' ">
                {{ rota.titulo }}
            </router-link>
        </li>
      </ul>
    </nav>
</template>

<script>

props: {
    rotas: {
        type: Array
    }
}

export default {
    data(){

    }
}
</script>

<style scoped>

</style>