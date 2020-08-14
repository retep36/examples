import Vue from 'vue'
import VueRouter from 'vue-router'
import Products from '../components/Products';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '',
      name: 'Products',
      component: Products,
    },
    {
      path: '/product-details',
      name: 'ProductDetail',
      component: ProductDetail,
    }
  ],
});
