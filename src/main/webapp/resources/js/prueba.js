/*
 * Aqui esta todo el codigo javascript que
 * permite hacer pruebas
 */

function sb() {
    Shadowbox.open({
        content: urlReenvioPaginaPrueba,
        player: "iframe",
        width: 966,
        height: 600,
        options: { modal:true,
                   overlayOpacity: 0.75 }
    });
}